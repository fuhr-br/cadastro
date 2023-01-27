package com.attornatus.cadastro.handler;

import java.util.List;

public record ApiErro(String mensagem, List<ApiErroDetalhe> erros) {
}
