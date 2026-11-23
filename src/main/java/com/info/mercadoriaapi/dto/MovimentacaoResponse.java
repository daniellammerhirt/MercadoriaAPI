package com.info.mercadoriaapi.dto;

import com.info.mercadoriaapi.model.Mercadoria;

public record MovimentacaoResponse(boolean ok, String msg, Mercadoria mercadoria) {

    public static MovimentacaoResponse erro(String msg){
        return new MovimentacaoResponse(false, msg, null);
    }
}
