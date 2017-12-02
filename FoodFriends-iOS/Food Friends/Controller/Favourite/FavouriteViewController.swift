//
//  FavouriteViewController.swift
//  Food Friends
//
//  Created by mac on 11/30/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit

class FavouriteViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {

    @IBOutlet var headerView: UIView!
    @IBOutlet var tableView: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        self.tableView.delegate = self
        self.tableView.dataSource = self
        setupTableView()
        setupView()
        // Do any additional setup after loading the view.
    }

    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 4
    }
    
    func setupView(){
        headerView.layer.shadowColor = UIColor(red: 0/255.0, green: 0/255.0, blue: 0/255.0, alpha: 0.08).cgColor
        headerView.layer.shadowOpacity = 1
        headerView.layer.shadowOffset = CGSize.zero
        headerView.layer.shadowRadius = 4
        headerView.layer.cornerRadius = 10
        
        tableView.layer.shadowColor = UIColor(red: 0/255.0, green: 0/255.0, blue: 0/255.0, alpha: 0.08).cgColor
        tableView.layer.shadowOpacity = 1
        tableView.layer.shadowOffset = CGSize.zero
        tableView.layer.shadowRadius = 4
        tableView.layer.cornerRadius = 10
    }
    
    func setupTableView(){
        let nib = UINib(nibName: "FavouriteTableViewCell", bundle: nil)
        self.tableView.register(nib, forCellReuseIdentifier: "FavouriteTableViewCell")
        
        self.tableView.rowHeight = UITableViewAutomaticDimension
        //self.tableView.estimatedRowHeight = 200
        
    }
    
    func tableView(tableView: UITableView, heightForRowAtIndexPath indexPath: NSIndexPath) -> CGFloat {
        return UITableViewAutomaticDimension;
    }
    
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell{
        
        let cell = self.tableView.dequeueReusableCell(withIdentifier: "FavouriteTableViewCell", for: indexPath) as! FavouriteTableViewCell
        return cell
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return self.view.frame.height / 8.0
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
