package br.com.yagovcb.conta_corrente.service.mapper;

import br.com.yagovcb.conta_corrente.model.Cliente;
import br.com.yagovcb.conta_corrente.service.dto.ClienteDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface ClienteMapper {


    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDto(Cliente entity);
}
