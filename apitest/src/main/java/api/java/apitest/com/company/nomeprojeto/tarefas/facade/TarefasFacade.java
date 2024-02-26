package api.java.apitest.com.company.nomeprojeto.tarefas.facade;

import org.springframework.stereotype.Service;

import api.java.apitest.com.company.nomeprojeto.tarefas.dto.TarefaDTO;

import java.util.*;

@Service
public class TarefasFacade {
    private static final Map<Long, TarefaDTO> tarefas = new HashMap<>();

    public TarefaDTO criar(TarefaDTO tarefaDTO){
        Long proximoId = tarefas.keySet().size() + 1L;
        tarefaDTO.setId(proximoId);
        tarefas.put(proximoId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTO atualizar(TarefaDTO tarefaDTO, Long tarefaId){
        tarefas.put(tarefaId, tarefaDTO);
        return tarefaDTO;
    }

    public TarefaDTO getById(Long tarefaId){
        return tarefas.get(tarefaId);
    }

    public List<TarefaDTO> getAll (){
        return new ArrayList<>(tarefas.values());
    }

    public String delete (Long tarefaId){
        tarefas.remove(tarefaId);
        return "DELETE";
    }

}
