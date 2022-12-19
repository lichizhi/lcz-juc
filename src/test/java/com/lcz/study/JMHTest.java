package com.lcz.study;

import com.lcz.study.threadPool.PS;
import org.openjdk.jmh.annotations.*;

public class JMHTest {

    @Benchmark
    @Warmup(iterations = 1, time = 3)
    @Fork(5)
    @BenchmarkMode(Mode.Throughput)
    @Measurement(iterations = 1, time = 3)
    public void testJMH() {
//        PS.foreach();
        PS.parallel();
    }
}
