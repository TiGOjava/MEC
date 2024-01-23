package com.MEC.Data;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
class DataService {

    private final LocalDataRepository localDataRepository;

    public DataService(LocalDataRepository localDataRepository) {
        this.localDataRepository = localDataRepository;
    }

    // Inicjalizacja danych przy starcie aplikacji
    @PostConstruct
    public void initializeData() {
        Flux.interval(Duration.ofMinutes(1))
                .zipWith(Flux.range(1, 100), (time, value) -> new LocalData(value))
                .flatMap(localDataRepository::save)
                .subscribe();
    }

    // Pobranie wszystkich danych
    public Flux<LocalData> getAllData() {
        return localDataRepository.findAll();
    }

    // Aktualizacja danych co 10 sekund
    @PostConstruct
    public void updateData() {
        Flux.interval(Duration.ofSeconds(10))
                .zipWith(Flux.range(1, Integer.MAX_VALUE), (time, value) -> value)
                .flatMap(value -> localDataRepository.findAll().take(1)
                        .flatMap(data -> {
                            data.setValue(value);
                            return localDataRepository.save(data);
                        }))
                .subscribe();
    }
}


