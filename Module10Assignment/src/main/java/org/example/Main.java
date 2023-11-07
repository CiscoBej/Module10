package org.example;

interface Tops {
    String getDescription();
}

interface Pants {
    String getDescription();
}

interface Shoes {
    String getDescription();
}

// Concrete Product Classes for Tops
class ProfessionalTops implements Tops {
    public String getDescription() { return "Professional Top"; }
}

class CasualTops implements Tops {
    public String getDescription() { return "Casual Top"; }
}

class PartyTops implements Tops {
    public String getDescription() { return "Party Top"; }
}


class ProfessionalPants implements Pants {
    public String getDescription() { return "Professional Pants"; }
}

class CasualPants implements Pants {
    public String getDescription() { return "Casual Pants"; }
}

class PartyPants implements Pants {
    public String getDescription() { return "Party Pants"; }
}


class ProfessionalShoes implements Shoes {
    public String getDescription() { return "Professional Shoes"; }
}

class CasualShoes implements Shoes {
    public String getDescription() { return "Casual Shoes"; }
}

class PartyShoes implements Shoes {
    public String getDescription() { return "Party Shoes"; }
}


interface GarmentFactory {
    Tops createTops();
    Pants createPants();
    Shoes createShoes();
}


class ProfessionalFactory implements GarmentFactory {
    public Tops createTops() { return new ProfessionalTops(); }
    public Pants createPants() { return new ProfessionalPants(); }
    public Shoes createShoes() { return new ProfessionalShoes(); }
}

class CasualFactory implements GarmentFactory {
    public Tops createTops() { return new CasualTops(); }
    public Pants createPants() { return new CasualPants(); }
    public Shoes createShoes() { return new CasualShoes(); }
}

class PartyFactory implements GarmentFactory {
    public Tops createTops() { return new PartyTops(); }
    public Pants createPants() { return new PartyPants(); }
    public Shoes createShoes() { return new PartyShoes(); }
}


class OutfitCreator {
    private Tops tops;
    private Pants pants;
    private Shoes shoes;

    public OutfitCreator(GarmentFactory factory) {
        tops = factory.createTops();
        pants = factory.createPants();
        shoes = factory.createShoes();
    }

    public void describeOutfit() {
        System.out.println("Outfit includes: " + tops.getDescription() + ", " + pants.getDescription() + ", and " + shoes.getDescription());
    }
}


public class Main {
    public static void main(String[] args) {

        GarmentFactory professionalFactory = new ProfessionalFactory();
        OutfitCreator professionalOutfit = new OutfitCreator(professionalFactory);
        professionalOutfit.describeOutfit();

        GarmentFactory casualFactory = new CasualFactory();
        OutfitCreator casualOutfit = new OutfitCreator(casualFactory);
        casualOutfit.describeOutfit();

        GarmentFactory partyFactory = new PartyFactory();
        OutfitCreator partyOutfit = new OutfitCreator(partyFactory);
        partyOutfit.describeOutfit();
    }
}

