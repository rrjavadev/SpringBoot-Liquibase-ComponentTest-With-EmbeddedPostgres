package com.experiments.book.entity;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.io.Serializable;

public class BookSequenceIdGenerator extends SequenceStyleGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        if (obj instanceof Identifiable) {
            Identifiable identifiable = (Identifiable) obj;
            Serializable id = identifiable.getId();
            //The generator only generates the id if the id field is empty. By default, SequenceStyleGenerator
            //auto-generates the primary key irrespective of whether it is already present in the object or not.
            if (id != null) {
                return id;
            }
        }
        return super.generate(session, obj);
    }
}
