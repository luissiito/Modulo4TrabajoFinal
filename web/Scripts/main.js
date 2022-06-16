
let txtFecha = document.querySelector('input[name="fecha"]');
let txtLastUpdate = document.querySelector('input[name="lastUpdate"]');
let d = new Date();
let minutos = d.getMinutes();
let segundos = d.getSeconds();
let mes = d.getMonth() + 1;
let dias = d.getDate();
minutos = (minutos < 10)? '0' + minutos:minutos;
segundos = (segundos < 10)? '0' + segundos:segundos;
mes = (mes < 10)? '0' + mes:mes;
dias = (dias < 10)? '0' + dias:dias;
txtLastUpdate.value =d.getFullYear() + '-' + mes + '-' + dias + ' ' + d.getHours() + ':' + minutos + ':' + segundos;
txtFecha.value =d.getFullYear() + '-' + mes + '-' + dias;
        /* Autor: Luis González*/