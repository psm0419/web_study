package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.controller.service.file.FileService;
import com.app.controller.service.user.UserService;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.file.FileInfo;
import com.app.dto.user.ProfileRequestForm;
import com.app.dto.user.User;
import com.app.dto.user.UserDupCheck;
import com.app.dto.user.UserProfileImage;
import com.app.dto.user.UserValidError;
import com.app.util.FileManager;
import com.app.util.LoginManager;
import com.app.validator.UserCutomValidator;

@Controller
public class CustomerController {

	@Autowired
	UserService userService;
	
	@Autowired
	FileService fileService;

	@GetMapping("/customer")
	public String customer() {
		return "quiz/quiz09/quiz09";
	}

	@PostMapping("/customer")
	public String customerAction() {
		return "quiz/quiz09/quiz09";
	}

	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}

	@PostMapping("/customer/signup")
	public String signupAction(/*@Valid*/ @ModelAttribute User user, BindingResult br, Model model) {
		//별도로 생성한 UserVaildError 객체 사용하는 케이스
		UserValidError userValidError = new UserValidError();
		boolean validResult =  UserCutomValidator.validate(user, userValidError);
		
		if(validResult == false) { //오류 발생
			//유효성 검증 통과 실패
			//저장 진행하지 않고 다시 가입페이지로 이동
			model.addAttribute("userValidError", userValidError);
			return "customer/signup";
		}
		
		
		/* bindingresult 사용하는 케이스
		//유효성 검증
		UserCutomValidator.validate(user, br);
		
		//유효성 검증 성공 여부
		
		if (br.hasErrors()) { // 제약조건에 걸린 에러가 있다
			List<ObjectError> errorList = br.getAllErrors();
			for (ObjectError er : errorList) {
				System.out.println(er.getObjectName());
				System.out.println(er.getDefaultMessage());
				System.out.println(er.getCode());
				System.out.println(er.getCodes());
			}
			return "customer/signup";			
		}
		*/

		// 검증 먼저 하고 저장
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		int result = userService.saveUser(user);
		System.out.println("저장 됐으면 1 출력, 결과: " + result);
		
		if (result > 0) {
			return "redirect:/main";
		} else {
			return "customer/signup";
		}
	}
	
//	@InitBinder("user")
//	public void initUserBinder(WebDataBinder binder) {
//		UserValidator validator = new UserValidator();
//		binder.addValidators(validator);
//	}	
	
	

	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}

	@PostMapping("/customer/login")
	public String loginAction(User user, HttpSession session) {
		
		//user   id pw 화면으로부터 전달
		// name userType : null
		
		//user 로그인 할 수 있게 정보가 들어있는지! 확인!
		user.setUserType( CommonCode.USER_USERTYPE_CUSTOMER );
		User loginUser = userService.checkUserLogin(user);
		
		if(loginUser == null) { // 아이디X? 아이디O&비번X  null
			return "customer/login";
		} else {  // 아이디&비번이 맞으면 loginUser 
			//로그인 정보가 맞아서 로그인 성공
			//session.setAttribute("loginUser", loginUser);
			//session.setAttribute("loginUserId", loginUser.getId());
			
			//로그인 성공시 세션에 로그인 ID 저장
			LoginManager.setSessionLogin(session, loginUser.getId());
			
//			log.info( loginUser.getId() + "사용자 로그인함");
			
			return "redirect:/main";
		}
	}

	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		LoginManager.logout(session);
//		session.invalidate();
		return "redirect:/main";
	}

	@GetMapping("/customer/mypage")
	public String mypage(HttpSession session, Model model) {
		
		//session 에 loginUserId 값이 존재유무
		//if(session.getAttribute("loginUserId") != null) { //로그인 상태
		if(LoginManager.isLogin(session)) {
			
			//로그인되어있는 사용자의 정보를 보여주기
			//User user = userService.findUserById( (String)session.getAttribute("loginUserId") );
			User user = userService.findUserById( LoginManager.getLoginUserId(session) );
			model.addAttribute("user", user);
			
			 //userid -> UserProfileImage -> (fileName) -> FileInfo
			
			UserProfileImage upi = userService.findUserProfileImageById(user.getId());
			
			if(upi != null) {
				FileInfo fileInfo = fileService.findFileInfoByFileName(upi.getFileName());
				model.addAttribute("fileInfo", fileInfo);
			}
			
			return "customer/mypage";
		}
		//로그인 안된 상태
		return "redirect:/customer/login";
		
		
		
	}

	@ResponseBody
	@RequestMapping("/customer/checkDupId")
	public String checkDupId(@RequestBody String data) {
		System.out.println("checkDupId 요청 들어옴");
		System.out.println(data);
		// 매개변수 data : 중복여부를 확인하고 싶은 아이디
		// DB에 아이디 있는지 확인
		boolean result = userService.isDuplicatedId(data);

		if (result == true) {
			return "Y";
		} else {
			return "N";
		}
	}

	@ResponseBody
	@RequestMapping("/customer/checkDupIdJson")
	public ApiResponse<String> checkDupIdJson(@RequestBody UserDupCheck userDupCheck) {
		// JSON format Text -> UserDupCheck 객체로 파싱
		System.out.println("checkDupIdJson 요청 들어옴");
		System.out.println(userDupCheck);

		// DB에 아이디 있는지 확인
		boolean result = userService.isDuplicatedId(userDupCheck.getId());

		ApiResponse<String> apiResponse = new ApiResponse<String>();
		ApiResponseHeader header = new ApiResponseHeader();
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultMessage(ApiCommonCode.API_RESULT_SUCCESS_MSG);

		apiResponse.setHeader(header);

		if (result == true) {
			apiResponse.setBody("Y");
		} else {
			apiResponse.setBody("N");
		}
		return apiResponse;
	}
	
//	@PostMapping("/customer/profile")
//	public String profile(HttpServletRequest request, MultipartRequest multipartRequest) {
//
//		System.out.println(request.getParameter("id"));
//		System.out.println(request.getParameter("name"));
//		
//		MultipartFile file =  multipartRequest.getFile("profileImage");
//		System.out.println(file.getName());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.isEmpty());
//		System.out.println(file.getContentType());
//		System.out.println(file.getSize());
//		
//		return "redirect:/customer/mypage";
//	}
	//객체로 하는 방법
	@PostMapping("/customer/profile")
	public String profileAction(ProfileRequestForm profileRequestForm) {
		
		System.out.println( profileRequestForm.getId() );
		System.out.println( profileRequestForm.getName() );
		
		MultipartFile file = profileRequestForm.getProfileImage();
		//첨부파일 수신
		
		//정보 확인
		System.out.println( file.getName()  );
		System.out.println( file.getOriginalFilename()  );
		System.out.println( file.isEmpty()  );
		System.out.println( file.getContentType() );
		System.out.println( file.getSize()  );
		
		//1. 실제 파일을 폴더에 저장
		
		/*
		//자체 저장
		try {
			file.transferTo( new File("d:/fileStorage/" + file.getOriginalFilename() )  );
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//FileManager 활용
		
		try {
			
			FileInfo fileInfo = FileManager.storeFile(file);
			//실제 폴더에 파일을 저장
		
			//2. 파일 정보를 DB에 저장
			int result = fileService.saveFileInfo(fileInfo);
			//파일 정보만 DB에 저장
			
			if(result > 0) {
//				log.info(fileInfo.getFileName() + " 파일 저장 잘됨");
				
				//UserProfileImage 에도 연결할수 있게 저장
				//저장된 파일이 어떤 유저의 프로필 이미지다! 연결 정보 저장!
				
				UserProfileImage upi = new UserProfileImage();
				//userid를 어디서 가져오나?
				//1) 세션 
				//2) view 에 hidden 으로 저장된 id를 같이 전송 
				upi.setId(profileRequestForm.getId());	//사용자id
				upi.setFileName(fileInfo.getFileName()); //파일name
				
				int result2 = userService.saveUserProfileImage(upi);
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/customer/mypage";
	}
}
