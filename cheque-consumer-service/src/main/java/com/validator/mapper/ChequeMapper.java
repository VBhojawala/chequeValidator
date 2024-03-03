package com.validator.mapper;

import com.validator.entity.EncashedCheque;
import com.validator.model.Cheque;

public interface ChequeMapper {
    EncashedCheque modelToEntity(Cheque cheque);

    Cheque entityToModel(EncashedCheque encashedCheque);
}
