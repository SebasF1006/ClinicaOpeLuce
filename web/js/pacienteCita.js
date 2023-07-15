function AgendarCita() {
    var id = $("input[name='id_pr']").val();
    window.location = "Cita?accion=GET&id=" + id;
}

function CitasPaciente() {
    var id = $("input[name='id_pr']").val();
    window.location = "Cita?accion=SEL&id=" + id;
}
                        
function ModificarDatosPaciente() {
    var id = $("input[name='id_pr']").val();
    window.location = "Paciente?accion=GET2&id=" + id;
}




