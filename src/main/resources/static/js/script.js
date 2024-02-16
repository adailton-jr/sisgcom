function atualizaDataeHora() {
    var agora = new Date();

    var dataFormatada = (agora.getDate() < 10 ? '0' : '') + agora.getDate() + '/' +
        (agora.getMonth() + 1 < 10 ? '0' : '') + (agora.getMonth() + 1) + '/' +
        agora.getFullYear();
    var horaFormatada = (agora.getHours() < 10 ? '0' : '') + agora.getHours() + ':' +
        (agora.getMinutes() < 10 ? '0' : '') + agora.getMinutes() + ':' +
        (agora.getSeconds() < 10 ? '0' : '') + agora.getSeconds();

    document.getElementById('data').innerText = dataFormatada;
    document.getElementById('hora').innerText = horaFormatada;
}

atualizaDataeHora();
setInterval(atualizaDataeHora, 1000);