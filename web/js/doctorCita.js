function CitasDoctor() {
    var id = $("input[name='id_pr']").val();
    window.location = "Cita?accion=SEL3&id=" + id;
}

function ModificarDatosDoctor() {
    var id = $("input[name='id_pr']").val();
    window.location = "Doctor?accion=GET2&id=" + id;
}
