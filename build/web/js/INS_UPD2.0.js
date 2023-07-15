
function pacienteUpd2() {    
    var id = $("input[name='id_upd']:checked").val();
    var idadmin = $("input[name='idadmin']").val();
    if (isNaN(id)) {
        alert("Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "Paciente?accion=GET&id=" + id+"&idadmin="+idadmin;
    }
}

function pacienteDel2() {
    var ids = [];
    var idadmin = $("input[name='idadmin']").val();
    $("input[name='id_del']:checked").each(function () {
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        alert("Advertencia\n\nSeleccione la(s) fila(s) a Retirar");
    } else {
        var exito = confirm('¿Seguro que deseas borrar los registros?');
        if (exito) {
            window.location = "Paciente?accion=DEL&ids=" + ids.toString()+"&idadmin="+idadmin;
        } else {
            alert("Operación cancelada");
        }
    }
}







