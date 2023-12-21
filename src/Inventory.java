public class Inventory {
    private Item[] items;
    private Storage[] storages;
    private int itemsCount;
    private int storagesCount;

    public Inventory() {
        this.items = new Item[10];
        this.storages = new Storage[10];
        this.itemsCount = 0;
        this.storagesCount = 0;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Storage[] getStorages() {
        return storages;
    }

    public void setStorages(Storage[] storages) {
        this.storages = storages;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public int getStoragesCount() {
        return storagesCount;
    }

    public void setStoragesCount(int storagesCount) {
        this.storagesCount = storagesCount;
    }

    public void addItem(Item item) {
        if (itemsCount < items.length) {
            items[itemsCount] = item;
            itemsCount++;
        } else {
            System.out.println("Неможливо додати товар. Обмеження кількості.");
        }
    }

    public void removeItem(Item item) {
        for (int i = 0; i < itemsCount; i++) {
            if (items[i].equals(item)) {
                for (int j = i; j < itemsCount - 1; j++) {
                    items[j] = items[j + 1];
                }
                itemsCount--;
                break;
            }
        }
    }

    public void moveItem(Item item, Storage fromStorage, Storage toStorage) {
        for (Item i : items) {
            if (i != null && i.equals(item) && i.getStorage().equals(fromStorage.getName())) {
                i.setStorage(toStorage.getName());
                break;
            }
        }
    }

    public void printItemsInStorage(Storage storage) {
        System.out.println("Товари на складі " + storage.getName() + ":");
        for (Item item : items) {
            if (item != null && item.getStorage() != null && item.getStorage().equals(storage.getName())) {
                System.out.println("Назва: " + item.getName() + ", Кількість: " + item.getNumber() + ", Ціна: " + item.getPrice());
            }
        }
    }

    public void addStorage(Storage storage) {
        if (storagesCount < storages.length) {
            storages[storagesCount] = storage;
            storagesCount++;
        } else {
            System.out.println("Неможливо додати склад. Обмеження кількості.");
        }
    }
}

class Storage {
    private String name;
    private int listNumber;

    public Storage(String name, int listNumber) {
        this.name = name;
        this.listNumber = listNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getListNumber() {
        return listNumber;
    }

    public void setListNumber(int listNumber) {
        this.listNumber = listNumber;
    }
}

class Item {
    private String name;
    private int number;
    private int price;
    private String storage;

    public Item(String name, int number, int price, String storage) {
        this.name = name;
        this.number = number;
        this.price = price;
        this.storage = storage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }
}
