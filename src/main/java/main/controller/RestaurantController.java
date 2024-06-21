package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import main.dto.BriefRestaurantDTO;
import main.dto.RestaurantDTO;
import main.pojo.ActivityOneDay;
import main.pojo.DishAnalysis;
import main.pojo.LoyalCustomerDistribution;
import main.pojo.MonthlyRevenue;
import main.pojo.OrderFrequency;
import main.pojo.Restaurant;
import main.pojo.RestaurantDetails;
import main.pojo.RestaurantSummary;
import main.pojo.UserGroupAnalysis;
import main.service.RestaurantReviewService;
import main.service.RestaurantService;
import main.service.UserService;
import main.service.DishService;
import main.service.OrderDetailService;
import main.service.OrderService;

import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    RestaurantReviewService restaurantReviewService;
    @Autowired
    DishService dishService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    UserService userService;

    @GetMapping("/searchRestaurantSummaries")
    public ResponseEntity<List<RestaurantSummary>> searchRestaurantSummaries(@RequestParam("keyword") String keyword){
        List<RestaurantSummary> restaurantSummaries = restaurantService.getRestaurantSummariesByKeyword(keyword);
        return ResponseEntity.ok(restaurantSummaries);        
    }

    @GetMapping("/searchRestaurants")
    public ResponseEntity<List<BriefRestaurantDTO>> searchRestaurants(@RequestParam("keyword") String keyword){
        List<BriefRestaurantDTO> restaurantDTOs = restaurantService.getRestaurantsByKeyword(keyword);
        return ResponseEntity.ok(restaurantDTOs);        
    } 

    @GetMapping("/details")
    public ResponseEntity<RestaurantDetails> selectRestaurantDetailsById(@RequestParam("id") Integer id) {
        RestaurantDetails restaurantDetails = restaurantService.getRestaurantDetailsById(id);
        return ResponseEntity.ok(restaurantDetails);
    }



    @GetMapping("/selectAll4U")
    public ResponseEntity<List<BriefRestaurantDTO>> selelctAll4U(){
        List<BriefRestaurantDTO> brestaurantDtos = restaurantService.selectAll4U();
        return ResponseEntity.ok(brestaurantDtos);
    }

    @GetMapping("/selectAll4M")
    public ResponseEntity<List<RestaurantDTO>> selelctAll4M(){
        List<RestaurantDTO> restaurantDtos = restaurantService.selectAll4M();
        return ResponseEntity.ok(restaurantDtos);
    }

    @GetMapping("selectPage4M")
    public ResponseEntity<List<RestaurantDTO>> selectPage4M(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum){
       return ResponseEntity.ok(restaurantService.selectPage4M(pageSize, pageNum));
    }
    


    @GetMapping("/selectById")
    public ResponseEntity<BriefRestaurantDTO> selectById(@RequestParam("restaurantId") Integer id){
        return ResponseEntity.ok(restaurantService.selectById(id));
    }

    @GetMapping("/analyzeDishes")
    public ResponseEntity<List<DishAnalysis>> analyzeAllDishesByRestaurantId(@RequestParam("restaurantId") Integer id) {
        List<DishAnalysis> dishAnalysis = dishService.analyzeDishByRestaurantId(id);
        return ResponseEntity.ok(dishAnalysis);
    }
    
    @GetMapping("/loyalCustomerDistribution")
    public ResponseEntity<List<LoyalCustomerDistribution>> getLoyalCustomerDistribution(@RequestParam("restaurantId") Integer restaurantId, 
                                                                                        @RequestParam("period") String period,
                                                                                        @RequestParam("threshold") Integer threshold) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime;
        
        switch (period) {
            case "周":
                startTime = now.minus(1,ChronoUnit.WEEKS);
                break;
            case "月":
                startTime = now.minus(1,ChronoUnit.MONTHS);
                break;
            case "年":
                startTime = now.minus(1,ChronoUnit.YEARS);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        Timestamp startTimeStamp = Timestamp.valueOf(startTime);
        List<LoyalCustomerDistribution> loyalCustomerDistributions = restaurantService.getLoyalCustomerDistribution(restaurantId, threshold, startTimeStamp);
        return ResponseEntity.ok(loyalCustomerDistributions);

    }

    @GetMapping("/orderFrequency")
    public ResponseEntity<List<OrderFrequency>> getOrderFrequency(@RequestParam("restaurantId") Integer restaurantId,@RequestParam("period") String period) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime;
        
        switch (period) {
            case "周":
                startTime = now.minus(1,ChronoUnit.WEEKS);
                break;
            case "月":
                startTime = now.minus(1,ChronoUnit.MONTHS);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }

        Timestamp starTimestamp = Timestamp.valueOf(startTime);
        List<OrderFrequency> orderFrequencies = orderService.getOrderFrequencyForRestaurantByPeriod(restaurantId, starTimestamp, period);
        return ResponseEntity.ok(orderFrequencies);
    }

    @GetMapping("/activity")
    public ResponseEntity<List<ActivityOneDay>> getActivityAnalysis(@RequestParam("restaurantId") Integer restaurantId,@RequestParam("period") String period) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime;
        switch (period) {
            case "周":
                startTime = now.minus(1,ChronoUnit.WEEKS);
                break;
            case "月":
                startTime = now.minus(1,ChronoUnit.MONTHS);
                break;
            case "年":
                startTime = now.minus(1,ChronoUnit.YEARS);
                break;
            default:
                return ResponseEntity.badRequest().build();
        }
        Timestamp starTimestamp = Timestamp.valueOf(startTime);
        List<ActivityOneDay> activityInOneDay = orderService.getActivityInOneDayForRestaurant(restaurantId, starTimestamp);
        return ResponseEntity.ok(activityInOneDay);
    }
    
    @GetMapping("/userGroupAnalysis")
    public ResponseEntity<List<UserGroupAnalysis>> getUserGroupAnalysis(@RequestParam("restaurantId") Integer restaurantId) {
        List<UserGroupAnalysis> userGroupAnalysis = restaurantService.getUserGroupAnalysis(restaurantId);
        return ResponseEntity.ok(userGroupAnalysis);
    }
    
    @GetMapping("/monthly-revenue")
    public ResponseEntity<List<MonthlyRevenue>> getThisYearMonthlyRevenue(@RequestParam("restaurantId") Integer restaurantId) {
        List<MonthlyRevenue> monthlyRevenues = restaurantService.getMonthlyRevenues(restaurantId);
        return ResponseEntity.ok(monthlyRevenues);
    }
    
    
    
    @PostMapping
    public boolean insert(@RequestBody Restaurant restaurant){
        return restaurantService.insert(restaurant);
    }

    

    @PutMapping
    public boolean update(@RequestBody Restaurant restaurant){
        return restaurantService.update(restaurant);
    }


    @DeleteMapping("/deleteById")
    public boolean deleteById(@RequestParam("restaurantId") Integer id){
        return restaurantService.deleteById(id);
    }


    
    
    
}
