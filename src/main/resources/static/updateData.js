$(document).ready(function() {
    const dataContainer = $('#dataContainer');

    const eventSource = new EventSource('/api/data');

    eventSource.onmessage = function (event) {
        const data = JSON.parse(event.data);
        dataContainer.text('Value: ' + data.value);
    };

    eventSource.onerror = function (error) {
        console.error('Błąd w połączeniu SSE:', error);
        eventSource.close();

        setTimeout(function() {
            location.reload();
        }, 5000);
    };
});
