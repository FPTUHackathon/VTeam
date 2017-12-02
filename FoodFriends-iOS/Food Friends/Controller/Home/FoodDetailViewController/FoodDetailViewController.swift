//
//  FoodDetailViewController.swift
//  Food Friends
//
//  Created by mac on 12/1/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit

class FoodDetailViewController: UIViewController {

    @IBOutlet var headerView: UIView!
    @IBOutlet var imageView: UIView!
    @IBOutlet var reviewView: UIView!
    @IBOutlet var collectionView: ReviewFoodCollectionView!
    @IBOutlet var bookingBtn: UIButton!
    override func viewDidLoad() {
        super.viewDidLoad()
        setupNib()
        setupView()
      
    }

    func setupNib(){
        let nib = UINib(nibName: "FoodDetailViewController", bundle:nil)
        let myVC = nib.instantiate(withOwner: self, options: nil).first as? FoodDetailViewController
    }
    
    func setupView(){
        // setup Btn Booking layer
        bookingBtn.layer.cornerRadius = 10
        
        // setup shadow of HeaderView
        headerView.layer.shadowColor = UIColor(red: 0/255.0, green: 0/255.0, blue: 0/255.0, alpha: 0.08).cgColor
        headerView.layer.shadowOpacity = 1
        headerView.layer.shadowOffset = CGSize.zero
        headerView.layer.shadowRadius = 4
        headerView.layer.cornerRadius = 10
        
        //setup shadow of image View
        imageView.layer.shadowColor = UIColor(red: 0/255.0, green: 0/255.0, blue: 0/255.0, alpha: 0.08).cgColor
        imageView.layer.shadowOpacity = 1
        imageView.layer.shadowOffset = CGSize.zero
        imageView.layer.shadowRadius = 4
        imageView.layer.cornerRadius = 10
        
        //setup shadow of Review View
        reviewView.layer.shadowColor = UIColor(red: 0/255.0, green: 0/255.0, blue: 0/255.0, alpha: 0.08).cgColor
        reviewView.layer.shadowOpacity = 1
        reviewView.layer.shadowOffset = CGSize.zero
        reviewView.layer.shadowRadius = 4
        reviewView.layer.cornerRadius = 10
        
    }
    @IBAction func invokeBackBtn(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    @IBAction func panHeaderView(_ sender: Any) {
        
    }
    
    
}
