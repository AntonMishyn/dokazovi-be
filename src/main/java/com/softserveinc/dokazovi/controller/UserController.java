package com.softserveinc.dokazovi.controller;

import com.softserveinc.dokazovi.annotations.ApiPageable;
import com.softserveinc.dokazovi.dto.user.ExpertPreviewDTO;
import com.softserveinc.dokazovi.entity.UserEntity;
import com.softserveinc.dokazovi.exception.ResourceNotFoundException;
import com.softserveinc.dokazovi.security.CurrentUser;
import com.softserveinc.dokazovi.security.UserPrincipal;
import com.softserveinc.dokazovi.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.softserveinc.dokazovi.controller.EndPoints.USER_EXPERTS;
import static com.softserveinc.dokazovi.controller.EndPoints.USER;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	@ApiOperation(value = "Get preview of random experts. Default 11 max per page.")
	@ApiPageable
	@GetMapping(USER_EXPERTS)
	public ResponseEntity<Page<ExpertPreviewDTO>> getExpertPreview(
			@PageableDefault(size = 11) Pageable pageable) {
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(userService.getExpertsPreview(pageable));
	}

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public UserEntity getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
		return userService.findById(userPrincipal.getId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
	}
}
