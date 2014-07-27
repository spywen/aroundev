package com.around.dev.utils.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by laurent on 27/07/2014.
 */
public class TimestampDeserializer extends JsonDeserializer<Timestamp> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String timestamp = jp.getText().trim();

        try {
            return new Timestamp(Long.valueOf(timestamp));
        } catch (NumberFormatException e) {
            logger.warn("Unable to deserialize timestamp : {) ", timestamp, e);
            return null;
        }
    }
}
