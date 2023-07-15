function administradorIns() {
    window.location = "administradorIns.jsp";
}

function administradorDel() {
    var ids = [];
    $("input[name='id_del']:checked").each(function () {
        ids.push($(this).val());
    });
    if (ids.length === 0) {
        alert("Advertencia\n\nSeleccione la(s) fila(s) a Retirar");
    } else {
        var exito = confirm('¿Seguro que deseas borrar los registros?');
        if (exito) {
            window.location = "Administrador?accion=DEL&ids=" + ids.toString();
        } else {
            alert("Operación cancelada");
        }
    }
}
function administradorUpd() {
    var id = $("input[name='id_upd']:checked").val();
    if (isNaN(id)) {
        alert("Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "Administrador?accion=GET&id=" + id;
    }
}

function prueba2() {
    var id = $("input[name='id_pr']").val();
    alert(id.toString());
    //window.location = "Administrador?accion=GET&id=" + id;
}

