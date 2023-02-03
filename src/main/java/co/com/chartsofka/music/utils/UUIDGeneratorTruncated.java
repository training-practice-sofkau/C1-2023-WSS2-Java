package co.com.chartsofka.music.utils;

import java.util.UUID;
import java.io.Serializable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

public class UUIDGeneratorTruncated implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return UUID.randomUUID().toString().substring(0,10);
    }
}
