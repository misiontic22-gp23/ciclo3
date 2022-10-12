class User extends Entity {
    
    constructor() {
        super("users/");
        this.name = '';
        this.email = '';
        this.password = '';
        this.roles = [];
    }
}