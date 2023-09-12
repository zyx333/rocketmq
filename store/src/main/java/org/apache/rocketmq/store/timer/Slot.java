/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.store.timer;

// 即时间轮中的一个槽位，每个slot表示某一时刻需要投递的所有消息信息
public class Slot {
    public static final short SIZE = 32;
    // 执行的时间戳
    public final long timeMs;
    // 该 slot 第一个 timeLog 的偏移量，即链表尾
    public final long firstPos;
    // 链表头
    public final long lastPos;
    // 该 slot 中timelog 的数量
    public final int num;
    public final int magic; //no use now, just keep it

    public Slot(long timeMs, long firstPos, long lastPos) {
        this.timeMs = timeMs;
        this.firstPos = firstPos;
        this.lastPos = lastPos;
        this.num = 0;
        this.magic = 0;
    }

    public Slot(long timeMs, long firstPos, long lastPos, int num, int magic) {
        this.timeMs = timeMs;
        this.firstPos = firstPos;
        this.lastPos = lastPos;
        this.num = num;
        this.magic = magic;
    }
}
