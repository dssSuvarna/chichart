package com.activ8.chichart.core.service.characteristics;

import com.activ8.chichart.core.domain.*;

import java.util.*;

public class PillarCharacteristicsProvider {
    private static Map<PillarCharacteristicsKey, String> descriptions = new HashMap<>();

    static {
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WOOD, Animal.RAT), "The energy of the Yang Wood Rat is intelligent, capable and determined");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WOOD, Animal.OX), "The energy of the Yin Wood Ox is charming, flexible and adaptable");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.FIRE, Animal.TIGER), "The energy of the Yang Fire Tiger is creative, intuitive and passionate");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.FIRE, Animal.RABBIT), "The energy of Yin Fire Rabbit is social, fun-loving and easy going");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.EARTH, Animal.DRAGON), "The energy of the Yang Earth Dragon is loyal, trustworthy and determined");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.EARTH, Animal.SNAKE), "The energy of the Yin Earth Snake is sensual, charming, intuitive and intelligent");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.METAL, Animal.HORSE), "The energy of the Yang Metal Horse is born-to-lead, competent, loyal and logical");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.METAL, Animal.SHEEP), "The energy of the Yin Metal Sheep is independent and self-motivated");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WATER, Animal.MONKEY), "The energy of the Yang Water Monkey is passionate, intelligent and resilient");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WATER, Animal.ROOSTER), "The energy of the Yin Water Rooster is kind, sensitive, spiritual and unconventional");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WOOD, Animal.DOG), "The energy of the Yang Wood Dog's energy is reliable, consistent and forthright");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WOOD, Animal.PIG), "The energy of the Yin Wood Pig is sensitive, perceptive, intelligent and resilient");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.FIRE, Animal.RAT), "The energy of the Yang Fire Rat is energetic, quick-witted and generous");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.FIRE, Animal.OX), "The energy of the Yin Fire Ox is creative, volatile and sensitive");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.EARTH, Animal.TIGER), "The energy of the Yang Earth Tiger is dependable, determined, and protective");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.EARTH, Animal.RABBIT), "The energy of the Yin Earth Rabbit is caring, resourceful and resilient");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.METAL, Animal.DRAGON), "The energy of the Yang Metal Dragon is intuitive, academic and driven");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.METAL, Animal.SNAKE), "The energy of the Yin Metal Snake is intelligent, strategic and successful");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WATER, Animal.HORSE), "The energy of the Yang Water Horse is intelligent, intuitive and passionate");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WATER, Animal.SHEEP), "The energy of the Yin Water Sheep is nurturing, sensitive and creative");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WOOD, Animal.MONKEY), "The energy of the Yang Wood Monkey is tough, resilient and adaptable");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WOOD, Animal.ROOSTER), "The energy of the Yin Wood Rooster is charming, refined and ambitious");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.FIRE, Animal.DOG), "The energy of the Yang Fire Dog is optimistic, popular and self-motivated");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.FIRE, Animal.PIG), "The energy of the Yin Fire Pig is kind, sensitive and responsible");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.EARTH, Animal.RAT), "The energy of the Yang Earth Rat is clever, intelligent and intuitive");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.EARTH, Animal.OX), "The energy of the Yin Earth Ox is creative, nurturing and protective");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.METAL, Animal.TIGER), "The energy of the Yang Metal Tiger is tough, smart and uncompromising");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.METAL, Animal.RABBIT), "The energy of the Yin Metal Rabbit is attractive, persuasive, principled and patient");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WATER, Animal.DRAGON), "The energy of the Yang Water Dragon is independent, determined and focused");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WATER, Animal.SNAKE), "The energy of the Yin Water Snake is principled , hard-working and knowledgeable");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WOOD, Animal.HORSE), "The energy of the Yang Wood Horse is born-to-lead, righteous, creative and kind");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WOOD, Animal.SHEEP), "The energy of the Yin Wood Sheep is sincere, inspirational, idealistic and creative");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.FIRE, Animal.MONKEY), "The energy of the Yang Fire Monkey is direct, driven, energetic and opportunistic");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.FIRE, Animal.ROOSTER), "The energy of the Yin Fire Rooster is attractive, magnetic, eloquent and helpful");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.EARTH, Animal.DOG), "The energy of the Yang Earth Dog is determined, relentless, honest and idealistic");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.EARTH, Animal.PIG), "The energy of the Yin Earth Pig is sensitive, protective and creative");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.METAL, Animal.RAT), "The energy of the Yang Metal Rat is creative, expressive and principled");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.METAL, Animal.OX), "The energy of Yin Metal Ox is sensitive, loyal, and cooperative");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WATER, Animal.TIGER), "The energy of the Yang Water Tiger is academic, passionate and emotional");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WATER, Animal.RABBIT), "The energy of the Yin Water Rabbit is attractive, personable, nurturing and adaptable");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WOOD, Animal.DRAGON), "The energy of the Yang Wood Dragon is intelligent, protective and opportunistic");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WOOD, Animal.SNAKE), "The energy of the Yin Wood Snake energy is sensual, appealing, adaptable and persistent");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.FIRE, Animal.HORSE), "The energy of the Yang Fire Horse is intelligent, ambitious and self-reliant");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.FIRE, Animal.SHEEP), "The energy of the Yin Fire Sheep is caring, compassionate and sensual");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.EARTH, Animal.MONKEY), "The energy the Yang Earth Monkey is creative, talented and intelligent");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.EARTH, Animal.ROOSTER), "The energy of the Yin Earth Rooster is nurturing, modest and creative");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.METAL, Animal.DOG), "The energy of the Yang Metal Dog is born-to lead, proud, noble and intelligent");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.METAL, Animal.PIG), "The energy of the Yin Metal Pig is perceptive, motivated, talented and creative");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WATER, Animal.RAT), "The energy of the Yang Water Rat is highly intelligent and intense");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WATER, Animal.OX), "The energy of the Yin Water Ox is social, sensitive and dependable");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WOOD, Animal.TIGER), "The energy of the Yang Wood Tiger is determined, self-motivated, protective and inspirational");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WOOD, Animal.RABBIT), "The energy of the Yin Wood Rabbit is attractive, fun-loving and social");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.FIRE, Animal.DRAGON), "The energy of the Yang Fire Dragon is self-motivated, inspirational, energetic and productive");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.FIRE, Animal.SNAKE), "The energy of the Yin Fire Snake is competitive, calculating and ambitious");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.EARTH, Animal.HORSE), "The energy of the Yang Earth Horse is patient, knowledgeable, secretive and proud");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.EARTH, Animal.SHEEP), "The energy of the Yin Earth Sheep is fun-loving, friendly, caring and adventurous");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.METAL, Animal.MONKEY), "The energy of the Yang Metal Monkey is perceptive, loyal and eccentric");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.METAL, Animal.ROOSTER), "The energy of the Yin Metal Rooster is attractive, self-confident, precise and perfect");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YANG, ElementType.WATER, Animal.DOG), "The energy of the Yang Water Dog is highly intelligent, capable and successful");
        descriptions.put(new PillarCharacteristicsKey(DualityType.YIN, ElementType.WATER, Animal.PIG), "The energy of the Yin Water Pig is competitive, combative, unconventional and controlling");
    }

    public String getDescription(Pillar pillar) {
        String description = "";
        PillarCharacteristicsKey key;

        if (pillar.isUseStem()) {
            key = new PillarCharacteristicsKey(pillar.getStem().getDuality().getType(), pillar.getStem().getElement().getType(), pillar.getBranch().getAnimal());
        } else {
            key = new PillarCharacteristicsKey(pillar.getBranch().getDuality().getType(), pillar.getStem().getElement().getType(), pillar.getBranch().getAnimal());
        }
        for (PillarCharacteristicsKey aKey : descriptions.keySet()) {
            if (key.getDualityType().equals(aKey.getDualityType())
                    && key.getElementType().equals(aKey.getElementType())
                    && key.getAnimal().equals(aKey.getAnimal())) {
                description = descriptions.get(aKey);
            }
        }
        return description;
    }
}

class PillarCharacteristicsKey {
    final private DualityType dualityType;
    final private ElementType elementType;
    final private Animal animal;

    public PillarCharacteristicsKey(DualityType dualityType, ElementType elementType, Animal animal) {
        this.dualityType = dualityType;
        this.elementType = elementType;
        this.animal = animal;
    }

    public DualityType getDualityType() {
        return dualityType;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public Animal getAnimal() {
        return animal;
    }
}

