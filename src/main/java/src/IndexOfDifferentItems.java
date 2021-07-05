package src;

public class IndexOfDifferentItems {
    private int indexOfName;
    private int indexOfPrice;
    private int indexOfType;
    private int indexOfExpiration;

    public IndexOfDifferentItems() {
        indexOfName = 0;
        indexOfPrice = 0;
        indexOfType = 0;
        indexOfExpiration = 0;
    }

    public int getIndexOfName() {
        return indexOfName;
    }

    public void setIndexOfName(int indexOfName) {
        this.indexOfName = indexOfName;
    }

    public int getIndexOfPrice() {
        return indexOfPrice;
    }

    public void setIndexOfPrice(int indexOfPrice) {
        this.indexOfPrice = indexOfPrice;
    }

    public int getIndexOfType() {
        return indexOfType;
    }

    public void setIndexOfType(int indexOfType) {
        this.indexOfType = indexOfType;
    }

    public int getIndexOfExpiration() {
        return indexOfExpiration;
    }

    public void setIndexOfExpiration(int indexOfExpiration) {
        this.indexOfExpiration = indexOfExpiration;
    }

    private int calculateIndex(String individualLine, String whatToLookFor) {
        return individualLine.indexOf(whatToLookFor) + whatToLookFor.length();
    }

    public void populateIndexes(String item) {
        indexOfName = calculateIndex(item, "name:");
        indexOfPrice = calculateIndex(item, "price:");
        indexOfType = calculateIndex(item, "type:");
        indexOfExpiration = calculateIndex(item, "expiration:");
    }

    public String toString() {
        return indexOfName + " " + indexOfPrice + " " + indexOfType + " " + indexOfExpiration;
    }
}
