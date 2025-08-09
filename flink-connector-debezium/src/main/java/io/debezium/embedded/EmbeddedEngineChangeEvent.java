/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package io.debezium.embedded;

import org.apache.flink.cdc.debezium.internal.DebeziumChangeFetcher;

import io.debezium.engine.ChangeEvent;
import io.debezium.engine.Header;
import io.debezium.engine.RecordChangeEvent;
import org.apache.kafka.connect.source.SourceRecord;

import java.util.List;

/**
 * Copied from Debezium project. Make it public to be accessible from {@link DebeziumChangeFetcher}.
 */
public class EmbeddedEngineChangeEvent<K, V, H> implements ChangeEvent<K, V>, RecordChangeEvent<V> {
    private final K key;
    private final V value;
    private final List<Header<H>> headers;
    private final SourceRecord sourceRecord;

    public EmbeddedEngineChangeEvent(
            K key, V value, List<Header<H>> headers, SourceRecord sourceRecord) {
        this.key = key;
        this.value = value;
        this.headers = headers;
        this.sourceRecord = sourceRecord;
    }

    public K key() {
        return this.key;
    }

    public V value() {
        return this.value;
    }

    public List<Header<H>> headers() {
        return this.headers;
    }

    public V record() {
        return this.value;
    }

    public String destination() {
        return this.sourceRecord.topic();
    }

    public Integer partition() {
        return this.sourceRecord.kafkaPartition();
    }

    public SourceRecord sourceRecord() {
        return this.sourceRecord;
    }

    public String toString() {
        String var10000 = String.valueOf(this.key);
        return "EmbeddedEngineChangeEvent [key="
                + var10000
                + ", value="
                + String.valueOf(this.value)
                + ", sourceRecord="
                + String.valueOf(this.sourceRecord)
                + "]";
    }
}
