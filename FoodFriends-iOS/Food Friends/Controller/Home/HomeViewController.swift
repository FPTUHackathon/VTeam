//
//  HomeViewController.swift
//  Food Friends
//
//  Created by mac on 11/30/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit

class HomeViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {

    @IBOutlet var tableView: UITableView!
    @IBOutlet var headerView: UIView!
    @IBOutlet var avatarImage: UIImageView!
    @IBOutlet var searchBar: UISearchBar!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupTableView()
        tableView.dataSource = self
        tableView.delegate = self
        setupView()
        // Do any additional setup after loading the view.
    }

    override func viewWillAppear(_ animated: Bool) {
        deselectCell()
    }
    
    func setupView(){
        avatarImage.layer.cornerRadius = avatarImage.frame.height / 2.0
        avatarImage.layer.masksToBounds = true
        
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 4
    }
    
    func setupTableView(){
        let nib = UINib(nibName: "HomeTableViewCell", bundle: nil)
        self.tableView.register(nib, forCellReuseIdentifier: "HomeTableViewCell")
        
        self.tableView.rowHeight = UITableViewAutomaticDimension
        //self.tableView.estimatedRowHeight = 200
        

    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return UITableViewAutomaticDimension;
    }


    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell{
      
         let cell = self.tableView.dequeueReusableCell(withIdentifier: "HomeTableViewCell", for: indexPath) as! HomeTableViewCell
        return cell
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return self.view.frame.height / 2.0
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
//        let foodDetailViewController = FoodDetailViewController(nibName: "FoodDetailViewController", bundle: nil)
//
//        self.navigationController?.pushViewController(foodDetailViewController, animated: true)
        let vc = FoodDetailViewController(nibName: "FoodDetailViewController", bundle: nil)
        self.present(vc, animated: true, completion: nil)
        
    }
    
    func tableView(_ tableView: UITableView, didDeselectRowAt indexPath: IndexPath) {
        deselectCell()
    }
    
    func deselectCell(){
        if let index = self.tableView.indexPathForSelectedRow{
            self.tableView.deselectRow(at: index, animated: true)
        }
    }

}
