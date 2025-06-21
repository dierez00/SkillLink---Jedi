//package com.skilllink.backend.entity.registroEvento;
//
//import java.time.LocalDateTime;
//
//public record DatosListadoRegistroEvento(
//        Long idRegistro,
//        Long idUsuario,
//        Long idEvento,
//        LocalDateTime fechaRegistro) {
//
//    public DatosListadoRegistroEvento(RegistroEvento registroEvento) {
//        this(registroEvento.getIdRegistro(),
//                registroEvento.getUsuario().getIdUsuario(),
//                registroEvento.getEvento().getIdEvento(),
//                registroEvento.getFechaRegistro());
//    }
//
//}
