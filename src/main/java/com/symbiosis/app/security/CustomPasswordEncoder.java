package com.symbiosis.app.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CustomPasswordEncoder extends BCryptPasswordEncoder {
}
