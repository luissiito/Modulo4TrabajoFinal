let nombreDeExcepcionSQL = document.querySelector('input[name="nombreDeExcepcionSQL"]');
if( nombreDeExcepcionSQL.value == 'SQLIntegrityConstraintViolationException'){
    CuadroInformativo.innerHTML = '<p style="color:red; font-size: 0.8em; margin-top:0.5em;">HAY INFORMACI&Oacute;N DEL CURSO EN OTRA(s) TABLA(s). NO LO PUEDE ELIMINAR.</p>';
    document.querySelector('main').before(CuadroInformativo);
}
let mensajeDeExcepcionSQL = document.querySelector('input[name="mensajeDeExcepcionSQL"]');
if( mensajeDeExcepcionSQL.value == 'Cannot add or update a child row: a foreign key constraint fails (`sustantiva`.`curso`, CONSTRAINT `facilitador_fk` FOREIGN KEY (`id_facilitador`) REFERENCES `facilitador` (`id`))'){
    CuadroInformativo.innerHTML = '<p style="color:red; font-size: 0.87em; margin-top:0.5em;">ID DE FACILITADOR NO ENCONTRADO. COMPRUEBE QUE EL ID DE FACILITADOR QUE EST&Aacute; TRATANDO DE INGRESAR EXISTA EN EL SISTEMA. NO SE PUDO REALIZAR LA OPERACI&Oacute;N. </p>';
    document.querySelector('main').before(CuadroInformativo);
}

