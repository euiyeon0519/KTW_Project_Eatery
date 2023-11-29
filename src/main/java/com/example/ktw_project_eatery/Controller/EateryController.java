//package com.example.ktw_project_eatery.Controller;
//
//import com.example.ktw_project_eatery.Dto.AddEateryRequest;
//import com.example.ktw_project_eatery.Dto.EateryListViewResponse;
//import com.example.ktw_project_eatery.Dto.EateryResponse;
//import com.example.ktw_project_eatery.Dto.EateryViewResponse;
//import com.example.ktw_project_eatery.Dto.UpdateEateryRequest;
//import com.example.ktw_project_eatery.Entity.Eatery;
//import com.example.ktw_project_eatery.Service.EateryService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//@RequestMapping("/eaterys")
//public class EateryController {
//
//    private final EateryService eateryService;
//
//    // 음식점 전체 조회 뷰
//    @GetMapping
//    public String getEaterys(Model model) {
//        List<EateryListViewResponse> eaterys = eateryService.findAll()
//                .stream()
//                .map(EateryListViewResponse::new)
//                .toList();
//        model.addAttribute("eaterys", eaterys);
//
//        return "eatery/eateryList";
//    }
//
//    // 음식점 상세 조회 뷰
//    @GetMapping("/{id}")
//    public String getEatery(@PathVariable Long id, Model model) {
//        Eatery eatery = eateryService.findById(id);
//        model.addAttribute("eatery", new EateryViewResponse(eatery));
//
//        return "eatery/eateryDetail";
//    }
//
//    // 음식점 등록 뷰
//    @GetMapping("/create")
//    public String newEatery(@RequestParam(required = false) Long id, Model model) {
//        if (id == null) {
//            model.addAttribute("eatery", new EateryViewResponse());
//        } else {
//            Eatery eatery = eateryService.findById(id);
//            model.addAttribute("eatery", new EateryViewResponse(eatery));
//        }
//
//        return "eatery/createEatery";
//    }
//
//    // 음식점 등록 처리
//    @PostMapping("/create")
//    public ResponseEntity<Eatery> addEatery(@RequestBody AddEateryRequest request) {
//        Eatery savedEatery = eateryService.save(request);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedEatery);
//    }
//
//    // 음식점 수정 뷰
//    @GetMapping("/edit/{id}")
//    public String editEatery(@PathVariable Long id, Model model) {
//        Eatery eatery = eateryService.findById(id);
//        model.addAttribute("eatery", new EateryViewResponse(eatery));
//
//        return "eatery/editEatery";
//    }
//
//    // 음식점 수정 처리
//    @PostMapping("/edit/{id}")
//    public ResponseEntity<Eatery> updateEatery(@PathVariable Long id, @RequestBody UpdateEateryRequest request) {
//        Eatery updatedEatery = eateryService.update(id, request);
//
//        return ResponseEntity.ok()
//                .body(updatedEatery);
//    }
//
//    // 음식점 삭제 처리
//    @PostMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteEatery(@PathVariable Long id) {
//        eateryService.delete(id);
//
//        return ResponseEntity.ok()
//                .build();
//    }
//}

package com.example.ktw_project_eatery.Controller;

import com.example.ktw_project_eatery.Dto.EateryDto;
import com.example.ktw_project_eatery.Service.EateryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/eaterys")
public class EateryController {

    private final EateryService eateryService;

    // 음식점 전체 조회 뷰
    @GetMapping
    public String getEaterys(Model model) {
        List<EateryDto> eateryDtos = eateryService.findAll();
        model.addAttribute("eaterys", eateryDtos);

        return "eatery/eateryList";
    }

    // 음식점 상세 조회 뷰
    @GetMapping("/{id}")
    public String getEatery(@PathVariable Long id, Model model) {
        EateryDto eateryDto = eateryService.findById(id);
        model.addAttribute("eatery", eateryDto);

        return "eatery/eateryDetail";
    }

    // 음식점 등록 뷰
    @GetMapping("/create")
    public String newEatery(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {
            model.addAttribute("eatery", new EateryDto());
        } else {
            EateryDto eateryDto = eateryService.findById(id);
            model.addAttribute("eatery", eateryDto);
        }

        return "eatery/createEatery";
    }

    // 음식점 등록 처리
    @PostMapping("/create")
    public ResponseEntity<EateryDto> addEatery(@RequestBody EateryDto eateryDto) {
        EateryDto savedEateryDto = eateryService.save(eateryDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedEateryDto);
    }

    // 음식점 수정 뷰
    @GetMapping("/edit/{id}")
    public String editEatery(@PathVariable Long id, Model model) {
        EateryDto eateryDto = eateryService.findById(id);
        model.addAttribute("eatery", eateryDto);

        return "eatery/editEatery";
    }

    // 음식점 수정 처리
    @PostMapping("/edit/{id}")
    public ResponseEntity<EateryDto> updateEatery(@PathVariable Long id, @RequestBody EateryDto eateryDto) {
        EateryDto updatedEateryDto = eateryService.update(id, eateryDto);

        return ResponseEntity.ok()
                .body(updatedEateryDto);
    }

    // 음식점 삭제 처리
    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEatery(@PathVariable Long id) {
        eateryService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
}
