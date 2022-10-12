class Role extends Entity {
    
    constructor() {
        super("roles/");
        this.name = '';
        this.description = '';
        this.users = [];
    }
}