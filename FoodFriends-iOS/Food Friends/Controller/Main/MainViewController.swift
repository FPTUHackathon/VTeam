//
//  MainViewController.swift
//  Food Friends
//
//  Created by mac on 11/30/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit
import Firebase
import ESTabBarController_swift

class MainViewController: ESTabBarController {

    override func viewDidLoad() {
        super.viewDidLoad()

       
        // Do any additional setup after loading the view.
    }
    
    func setup(){
        self.delegate = nil
        self.title = "Irregularity"
        //self.tabBar.shadowImage = UIImage(named: "transparent")
       // self.tabBar.backgroundImage = UIImage(named: "background_dark")
      //  self.tabBar.barTintColor = UIColor.white
        self.shouldHijackHandler = {
            
            tabbarController, viewController, index in
            if index == 2 {
                return true
            }
            return false
        }
        self.didHijackHandler = {
            [weak tabBarController] tabbarController, viewController, index in
                let chatViewController = ChatViewController(nibName: "ChatViewController",bundle: nil)
                self.present(chatViewController, animated: true, completion: nil)
        }
    }
    
    @objc func handleTouchTabbarCenter(sender : UIButton)
    {
        if let count = self.tabBar.items?.count
        {
            let i = floor(Double(count / 2))
            self.selectedViewController = self.viewControllers?[Int(i)]
        }
    }
  
    
    override func viewDidAppear(_ animated: Bool) {
        let nib = UINib(nibName: "MainViewController", bundle:nil)
        let myVC = nib.instantiate(withOwner: self, options: nil).first as? MainViewController
        
        setup()
  
        
//        let tabTwoBarItem1 = UITabBarItem(title: nil, image: UIImage(named: "home")?.withRenderingMode(UIImageRenderingMode.alwaysOriginal), selectedImage: nil)
//        let tabTwoBarItem2 = UITabBarItem(title: nil, image: UIImage(named: "heart")?.withRenderingMode(UIImageRenderingMode.alwaysOriginal), selectedImage: nil)
//        let tabTwoBarItem3 = UITabBarItem(title: nil, image: UIImage(named: "heart")?.withRenderingMode(UIImageRenderingMode.alwaysOriginal), selectedImage: nil)
        

        let homeViewController = HomeViewController(nibName: "HomeViewController",bundle: nil)
        homeViewController.tabBarItem = ESTabBarItem.init(ExampleIrregularityBasicContentView(), title: "Trang chủ", image: UIImage(named: "home")?.withRenderingMode(UIImageRenderingMode.alwaysOriginal), selectedImage: UIImage(named: "homeFilled")?.withRenderingMode(UIImageRenderingMode.alwaysOriginal))
        
        let favouriteViewController = FavouriteViewController(nibName: "FavouriteViewController",bundle: nil)
        favouriteViewController.tabBarItem = ESTabBarItem.init(ExampleIrregularityBasicContentView(), title: "Yêu thích", image: UIImage(named: "heart"), selectedImage: UIImage(named: "heartFilled"))
        
        let chatViewController = ChatViewController(nibName: "ChatViewController",bundle: nil)
        chatViewController.tabBarItem = ESTabBarItem.init(ExampleIrregularityContentView(), title: nil, image: UIImage(named: "photo_verybig"), selectedImage: UIImage(named: "photo_verybig"))
        
        let controllers = [homeViewController,favouriteViewController,chatViewController]
        self.viewControllers = controllers
        //  self.viewControllers = [homeViewController]
        
    }
    func tabBarController(_ tabBarController: UITabBarController, didSelectViewController viewController: UIViewController) {
        print("Selected \(viewController.title!)")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
