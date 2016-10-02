package cn.thinking.system.sequence.service.impl;

import org.springframework.stereotype.Service;

import cn.thinking.org.system.sequence.Sequence;
import cn.thinking.system.sequence.dao.SequenceMapper;
import cn.thinking.system.sequence.service.SequenceService;

@Service
public class SequenceServiceImpl implements SequenceService {

    private SequenceMapper sequenceMapper;

    public SequenceMapper getSequenceMapper() {
        return sequenceMapper;
    }

    public void setSequenceMapper(SequenceMapper sequenceMapper) {
        this.sequenceMapper = sequenceMapper;
    }

    @Override
    public int getCurrent(String seqName) {
        return sequenceMapper.getCurrent(seqName);
    }

    @Override
    public int getNextVal(String seqName) {
        return sequenceMapper.getNextVal(seqName);
    }

    @Override
    public void setVal(Sequence sequence) {
        sequenceMapper.setVal(sequence);
    }

    @Override
    public void insertSequence(Sequence sequence) {
        sequenceMapper.insertSequence(sequence);
    }

}
