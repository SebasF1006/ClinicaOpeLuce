function citaIns() {
    var idpacientes = $("input[name='idX']").val();
    window.location = "Cita?accion=GET&idpacientes=" + idpacientes;
}

function prueba(){
    //var id = document.getElementById("ElementoGuardado");
    alert("id");
    alert("Operación cancelada");
}

/*function citaDel() {
    var ids = [];
    $("input[name='id_del']:checked").each(function () {
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        alert("Advertencia\n\nSeleccione la(s) fila(s) a Retirar");
    } else {
        var exito = confirm('¿Seguro que deseas borrar los registros?');
        if (exito) {
            window.location = "Cita?accion=DEL&ids=" + ids.toString();
        } else {
            alert("Operación cancelada");
        }
    }
}*/
function citaUpd() {
    var id = $("input[name='id_upd']:checked").val();
    if (isNaN(id)) {
        alert("Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "Cita?accion=GET&id=" + id;
    }
}


