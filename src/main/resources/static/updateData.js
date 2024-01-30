// updateBattery.js
$(document).ready(function() {
    const dataContainer = $('#dataContainer');
    const batteryLevel = $('.battery-level');

    const eventSource = new EventSource('/api/data');

    eventSource.onmessage = function (event) {
        const data = JSON.parse(event.data);
        const value = data.value;

        dataContainer.text(value + '%'); // Aktualizuj procenty

        // Ustaw wysokość i kolor baterii na podstawie wartości procentowej
        batteryLevel.css('height', value + '%');

        if (value <= 10) {
            batteryLevel.css('background-color', 'rgb(188, 0, 0)');
        } else if (value <= 20) {
            batteryLevel.css('background-color', 'red');
        } else if (value <= 30) {
            batteryLevel.css('background-color', 'rgb(255, 85, 0)');
        } else if (value <= 40) {
            batteryLevel.css('background-color', 'rgb(255, 136, 0)');
        } else if (value <= 50) {
            batteryLevel.css('background-color', '#ffd500');
        } else if (value <= 60) {
            batteryLevel.css('background-color', 'rgb(225, 255, 0)');
        } else if (value <= 70) {
            batteryLevel.css('background-color', 'rgb(187, 255, 0)');
        } else if (value <= 80) {
            batteryLevel.css('background-color', 'rgb(145, 255, 0)');
        } else if (value <= 90) {
            batteryLevel.css('background-color', 'rgb(81, 255, 0)');
        } else {
            batteryLevel.css('background-color', '#00ff2f');
        }
    };

    eventSource.onerror = function (error) {
        console.error('Błąd w połączeniu SSE:', error);
        eventSource.close();

        setTimeout(function() {
            location.reload();
        }, 10000);
    };
});
