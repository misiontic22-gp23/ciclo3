class Category extends Entity {
    
    constructor() {
        super("categories/");
        this.name = '';
        this.description = '';
        this.parent = null;
        this.children = [];
    }
}