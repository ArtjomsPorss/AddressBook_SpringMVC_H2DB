package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.ApplicationService;

public class BaseController {
	@Autowired
	ApplicationService applicationService;

}
