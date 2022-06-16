
let nombreDeExcepcionSQL = document.querySelector('input[name="nombreDeExcepcionSQL"]');
if( nombreDeExcepcionSQL.value == 'SQLIntegrityConstraintViolationException'){
    CuadroInformativo.innerHTML = '<p style="color:red; font-size: 0.8em; margin-top:0.5em;">HAY INFORMACI&Oacute;N DE LA MATR&Iacute;CULA EN OTRA(s) TABLA(s). NO LA PUEDE ELIMINAR.</p>';
    document.querySelector('main').before(CuadroInformativo);
}
let mensajeDeExcepcionSQL = document.querySelector('input[name="mensajeDeExcepcionSQL"]');
if( mensajeDeExcepcionSQL.value == 'Cannot add or update a child row: a foreign key constraint fails (`sustantiva`.`matricula`, CONSTRAINT `matriculados_fk` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`))'){
    CuadroInformativo.innerHTML = '<p style="color:red; font-size: 0.87em; margin-top:0.5em;">ID DE ESTUDIANTE NO ENCONTRADO. COMPRUEBE QUE EL ID DE ESTUDIANTE QUE EST&Aacute; TRATANDO DE INGRESAR EXISTA EN EL SISTEMA. NO SE PUDO REALIZAR LA OPERACI&Oacute;N.</p>';
    document.querySelector('main').before(CuadroInformativo);
}
if( mensajeDeExcepcionSQL.value == 'Cannot add or update a child row: a foreign key constraint fails (`sustantiva`.`matricula`, CONSTRAINT `curso_con_matriculados_fk` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`))'){
    CuadroInformativo.innerHTML = '<p style="color:red; font-size: 0.87em; margin-top:0.5em;">ID DE CURSO NO ENCONTRADO. COMPRUEBE QUE EL ID DE CURSO QUE EST&Aacute; TRATANDO DE INGRESAR EXISTA EN EL SISTEMA. NO SE PUDO REALIZAR LA OPERACI&Oacute;N.</p>';
}
if( mensajeDeExcepcionSQL.value == "Duplicate entry '1-1' for key 'PRIMARY'"){
    CuadroInformativo.innerHTML = '<p style="color:red; font-size: 0.87em; margin-top:0.5em;">LOS DATOS INGRESADOS CORRESPONDEN A UNA MATR&Iacute;CULA QUE YA EXISTE EN EL SISTEMA. NO SE PUDO REALIZAR LA OPERACI&Oacute;N.</p>';
    document.querySelector('main').before(CuadroInformativo);
}
        /* Autor: Luis González*/