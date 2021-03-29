/**
 * This class represents a FoodItem Object
 * 
 * @author (Ben Cohen) 
 * @version (2020a)
 */

public class FoodItem{
    private String _name;
    private long _catalogueNumber;
    private int _quantity;
    private Date _productionDate;
    private Date _expiryDate;
    private int _minTemperature;
    private int _maxTemperature;
    private int _price;
    private int MAX_CATALOGUE_NUMBER=9999;
    private int MIN_CATALOGUE_NUMBER=1000;
    private int DEFAULT_PRICE=1;
    /**
     * creates a new FoodItem object
     * @param name name of food item
     * @param catalogueNumber catalogue number of food item
     * @param quantity quantity of food item
     * @param productionDate production date
     * @param expiryDate expiry date
     * @param minTemperature minimum storage temperature
     * @param maxTemperature maximum storage temperature
     * @param price unit price
     */
    public FoodItem(String name,long catalogueNumber ,int quantity,Date productionDate, Date expiryDate, int minTemperature, int maxTemperature, int price){
        if(name.isEmpty())//checking if the user entered an empty name : ""
            _name="item";
        else
            _name=name;
        if(catalogueNumber>=MIN_CATALOGUE_NUMBER&&catalogueNumber<=MAX_CATALOGUE_NUMBER)//checking the validation of the catalogue number
            _catalogueNumber=catalogueNumber;
        else
            _catalogueNumber=MAX_CATALOGUE_NUMBER;
        if(quantity>=0)//checking the validation of the quantity
            _quantity=quantity;
        else
            _quantity=0;
        if(productionDate.before(expiryDate)){//checking the validation of the production and expiry dates
            _productionDate=new Date(productionDate);
            _expiryDate=new Date(expiryDate);}
        else if(productionDate.after(expiryDate)){
            _productionDate=new Date(productionDate);
            _expiryDate=new Date(productionDate.tomorrow());}
        if(minTemperature<=maxTemperature){//checking the validation of the min and max temperatures
            _minTemperature=minTemperature;
            _maxTemperature=maxTemperature;}
        else{
            _minTemperature=maxTemperature;
            _maxTemperature=minTemperature;}
        if(price>0)//checking the validation of the price
            _price=price;
        else
            _price=DEFAULT_PRICE;
    }

    /**
     * copy constructor
     * @param other the food item to be copied
     */
    public FoodItem(FoodItem other){
        this._name=other._name;
        this._catalogueNumber=other._catalogueNumber;
        this._quantity=other._quantity;
        this._productionDate=new Date(other._productionDate);
        this._expiryDate=new Date(other._expiryDate);
        this._minTemperature=other._minTemperature;
        this._maxTemperature=other._maxTemperature;
        this._price=other._price;
    }

    /**
     * gets the name
     * @return the name
     */

    public String getName(){
        return this._name;
    }

    /**
     * gets the cataloguenumber
     * @return the catalogue number
     */

    public long getCatalogueNumber(){
        return this._catalogueNumber;
    }

    /**
     * gets the quantity
     * @return the quantity
     */

    public int getQuantity(){
        return this._quantity;
    }

    /**
     * gets the production date
     * @return the production date
     */

    public Date getProductionDate(){
        return new Date(this._productionDate);
    }

    /**
     * gets the expiry date
     * @return the expiry date
     */

    public Date getExpiryDate(){
        return new Date(this._expiryDate);
    }

    /**
     * gets the min temperature
     * @return the min temperature
     */

    public int getMinTemperature(){
        return this._minTemperature;
    }

    /**
     * gets the max temperature
     * @return the max temperature
     */

    public int getMaxTemperature(){
        return this._maxTemperature;
    }

    /**
     * gets the price
     * @return the price
     */

    public int getPrice(){
        return this._price;
    }

    /**
     * set the quantity (only if not negative)
     * @param quantityToSet the quantity value to be set
     */

    public void setQuantity(int quantityToSet){
        if(quantityToSet<0)
            _quantity=_quantity;
        else
            _quantity=quantityToSet;
    }

    /**
     * set the production date (only if not after expiry date ) 
     * @param productionDateToSet the quantity value to be set
     */

    public void setProductionDate(Date productionDateToSet){
        if(productionDateToSet.before(_expiryDate))
            _productionDate=new Date(productionDateToSet);
        else
            _productionDate=new Date(_productionDate);
    }

    /**
     * set the expiry date (only if not before production date ) 
     * @param expiryDateToSet the quantity value to be set
     */

    public void setExpiryDate(Date expiryDateToSet){
        if(_productionDate.after(expiryDateToSet))
            _expiryDate=new Date(_expiryDate);
        else
            _expiryDate=new Date(expiryDateToSet);
    }

    /**
     * set the price (only if positive) 
     * @param priceToSet the quantity value to be set
     */

    public void setPrice(int priceToSet){
        if(priceToSet>0)
            _price=priceToSet;
        else
            _price=_price;
    }

    /**
     * check if 2 food items are the same (excluding the quantity values) 
     * @param other the food item to compare this food item to
     * @return true if the food items are the same
     */

    public boolean equals(FoodItem other){
        if((this._name.equals(other._name))&&(this._catalogueNumber==other._catalogueNumber)&&(this._productionDate.equals(other._productionDate))&&
        (this._expiryDate.equals(other._expiryDate))&&(this._minTemperature==other._minTemperature)&&(this._maxTemperature==other._maxTemperature)&&(this._price==other._price))
            return true;
        return false;
    }

    /**
     * check if this food item is fresh on the date d 
     * @param d date to check
     * @return true if this food item is fresh on the date d
     */

    public boolean isFresh(Date d){
        if(((d.before(_expiryDate))||(d.equals(_expiryDate)))&&((d.after(_productionDate))||(d.equals(_productionDate))))
            return true;
        return false;
    }

    /**
     * returns a String that represents this food item
     * @return String that represents this food item in the following format:
     * FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3
     */

    public String toString(){
        return "FoodItem: "+_name+"\t"+"CatalogueNumber: "+_catalogueNumber+"\t"+"ProductionDate: "+_productionDate+"\t"+"ExpiryDate: "+_expiryDate+"\t"+"Quantity: "+_quantity;
    }

    /**
     * check if this food item is older than other food item 
     * @param other food item to compare this food item to 
     * @return true if this food item is older than other date
     */

    public boolean olderFoodItem(FoodItem other){
        if(this._productionDate.before(other._productionDate))
            return true;
        return false;
    }

    /**
     * returns the number of units of products that can be purchased for a given amount 
     * @param money money to purchase with
     * @return the number of units can be purchased
     */

    public int howManyItems(int money){
        if(money>0){
            int items=(money/_price);
            if(items>_quantity)
                return _quantity;
            return items;}
        else
            return 0;
    }

    /**
     * check if this food item is cheaper than other food item 
     * @param other food item to compare this food item to 
     * @return true if this food item is cheaper than other date
     */

    public boolean isCheaper(FoodItem other){
        if(other._price>this._price)
            return true;
        return false;
    }
}
