package by.planner.features;

import by.planner.exceptions.TaskCheckedException;

public enum Category{
    CHILLOUT(1),
    HOMEWORK(2),
    STUDY(3),
    WORK(4);

    private int categoryNum;

    Category(int categoryNum){
        this.categoryNum = categoryNum;
    }

    public void setCategoryNum(int categoryNum){
        this.categoryNum = categoryNum;
    }

    public int getCategoryNum(){
        return categoryNum;
    }

    public static Category returnCategory(int categoryNum) throws TaskCheckedException{
        Category category;
        switch (categoryNum) {
            case 1:
                category = Category.CHILLOUT;
                break;
            case 2:
                category = Category.HOMEWORK;
                break;
            case 3:
                category = Category.STUDY;
                break;
            case 4:
                category = Category.WORK;
                break;
            default:
                category = null;
                break;
        }
        if (category == null) {
            throw new TaskCheckedException("Invalid category");
        }
        return category;
    }

}
