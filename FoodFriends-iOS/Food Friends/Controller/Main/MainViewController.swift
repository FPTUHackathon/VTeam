//
//  MainViewController.swift
//  Food Friends
//
//  Created by mac on 11/30/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit

class MainViewController: UITabBarController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    
    override func viewDidAppear(_ animated: Bool) {
        let homeViewController = HomeViewController(nibName: "HomeViewController",bundle: nil)
        let tabTwoBarItem1 = UITabBarItem(title: "Home", image: nil, selectedImage: nil)
        homeViewController.tabBarItem = tabTwoBarItem1
        
        let favouriteViewController = FavouriteViewController(nibName: "FavouriteViewController",bundle: nil)
        let tabTwoBarItem2 = UITabBarItem(title: "favor", image: nil, selectedImage: nil)
        favouriteViewController.tabBarItem = tabTwoBarItem2
        
        let controllers = [homeViewController,favouriteViewController]
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
