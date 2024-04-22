package com.example.reactspringboot.constants;

public class Constants {

    public static final String ROLE_PREFIX = "ROLE_";
    public static final String AUTHORITY_DELIMITER = ",";
    public static final String USER_AUTHORITIES = "document:create,document:update,document:delete,document:read";
    public static final String ADMIN_AUTHORITIES = "user:create,user:update,user:read,document:create,document:update,document:delete,document:read";
    public static final String SUPER_ADMIN_AUTHORITIES="user:create,user:read,user:update,document:create,document:read,document:update,document:delete";
    public static final String MANAGER_AUTHORITIES = "document:create,document:update,document:delete,document:read";


}