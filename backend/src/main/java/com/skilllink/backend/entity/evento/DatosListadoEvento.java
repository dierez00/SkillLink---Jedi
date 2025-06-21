//package com.skilllink.backend.entity.evento;
//
//import java.time.LocalDateTime;
//
//public record DatosListadoEvento(
//        Long idEvento,
//        String titulo,
//        String descripcion,
//        String ubicacion,
//        LocalDateTime fechaEvento,
//        String organizador) {
//
//    public DatosListadoEvento(Evento evento) {
//        this(evento.getIdEvento(),
//                evento.getTitulo(),
//                evento.getDescripcion(),
//                evento.getUbicacion(),
//                evento.getFechaEvento(),
//                evento.getOrganizador());
//    }
//}
