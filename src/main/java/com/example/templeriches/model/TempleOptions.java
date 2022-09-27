package com.example.templeriches.model;

public class TempleOptions {
    int fireHazardCount;
    int rocksHazardCount;
    int snakesHazardCount;
    int spiderHazardCount;
    int zombieHazardCount;

    public TempleOptions(int fireHazardCount, int rocksHazardCount, int snakesHazardCount, int spiderHazardCount, int zombieHazardCount) {
        this.fireHazardCount = fireHazardCount;
        this.rocksHazardCount = rocksHazardCount;
        this.snakesHazardCount = snakesHazardCount;
        this.spiderHazardCount = spiderHazardCount;
        this.zombieHazardCount = zombieHazardCount;
    }
}
