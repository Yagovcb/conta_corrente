package br.com.yagovcb.conta_corrente.service.mapper;

import br.com.yagovcb.conta_corrente.model.Transacao;
import br.com.yagovcb.conta_corrente.service.dto.TransacaoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TransacaoMapper {

    Transacao toEntity(TransacaoDTO dto);

    TransacaoDTO toDto(Transacao entity);
}
