package com.example.templeriches.model;

public class TempleOptions {
    int fireHazardCount;
    int rocksHazardCount;
    int snakesHazardCount;
    int spiderHazardCount;
    int zombieHazardCount;
    int trinketCount;

    public TempleOptions(int fireHazardCount, int rocksHazardCount, int snakesHazardCount, int spiderHazardCount, int zombieHazardCount, int trinketCount) {
        this.fireHazardCount = fireHazardCount;
        this.rocksHazardCount = rocksHazardCount;
        this.snakesHazardCount = snakesHazardCount;
        this.spiderHazardCount = spiderHazardCount;
        this.zombieHazardCount = zombieHazardCount;
        this.trinketCount = trinketCount;
    }
}
