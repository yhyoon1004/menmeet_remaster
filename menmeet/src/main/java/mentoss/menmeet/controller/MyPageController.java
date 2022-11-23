package mentoss.menmeet.controller;

import lombok.RequiredArgsConstructor;
import mentoss.menmeet.DTO.myPage.AppliedMentoringDTO;
import mentoss.menmeet.DTO.myPage.ChangeStateDTO;
import mentoss.menmeet.DTO.myPage.CheckPasswordStateDTO;
import mentoss.menmeet.DTO.myPage.MyMentoringPostIndexDTO;
import mentoss.menmeet.service.MyPageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/myPage")
@RestController
@RequiredArgsConstructor
public class MyPageController {
	private final MyPageService myPageService;

	@PostMapping(value = "/checkPassword",consumes = "application/json")
	public CheckPasswordStateDTO checkPassword(@RequestBody String userPassword){
		return myPageService.checkPassword(userPassword);//미구현
	}

	@PostMapping(value = "/changePassword", consumes = "application/json")
	public ChangeStateDTO changePassword(@RequestBody String userPassword){
		return myPageService.changePassword(userPassword);//미구현
	}


	//내가 작성한 게시물 조회
	@GetMapping("/myPosts/{userId}")
	public List<MyMentoringPostIndexDTO> showMyPosts(@PathVariable String userId){
		return myPageService.showUserPosts(userId);
	}
	
	//내가 신청한 멘토링 조회
	@GetMapping("/myAppliedMentoring/{userId}")
	public List<AppliedMentoringDTO> showMyApplications(@PathVariable String userId){
		return myPageService.showMentoringMyApplication(userId);
	}


}
