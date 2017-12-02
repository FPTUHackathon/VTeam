//
//  ReviewFoodCollectionViewCell.swift
//  Food Friends
//
//  Created by mac on 12/1/17.
//  Copyright © 2017 HiepHo. All rights reserved.
//

import UIKit

class ReviewFoodCollectionViewCell: UICollectionViewCell {

    @IBOutlet var reviewView: UIView!
   
    @IBOutlet var textView: UITextView!
    
    

    override func awakeFromNib() {
        super.awakeFromNib()

        setupView()
        // Initialization code
    }

    func setupView(){
        reviewView.layer.cornerRadius = 10
        
        textView.text = "jdfhgsjhdgsfhjdfskfjasdhdfkjahsdfkjldsfhdklsjhdsfakjlsdhfsdkjhdfskcnxmcvbmncxmjdfhgsjhdgsfhjdfskfjasdhdfkjahsdfkjldsfhdklsjhdsfakjlsdhfsdkjhdfskcnxmcvbmncxmjdfhgsjhdgsfhjdfskfjasdhdfkjahsdfkjldsfhdklsjhdsfakjlsdhfsdkjhdfskcnxmcvbmncxmjdfhgsjhdgsfhjdfskfjasdhdfkjahsdfkjldsfhdklsjhdsfakjlsdhfsdkjhdfskcnxmcvbmncxmjdfhgsjhdgsfhjdfskfjasdhdfkjahsdfkjldsfhdklsjhdsfakjlsdhfsdkjhdfskcnxmcvbmncxmjdfhgsjhdgsfhjdfskfjasdhdfkjahsdfkjldsfhdklsjhdsfakjlsdhfsdkjhdfskcnxmcvbmncxmjdfhgsjhdgsfhjdfskfjasdhdfkjahsdfkjldsfhdklsjhdsfakjlsdhfsdkjhdfskcnxmcvbmncxmjdfhgsjhdgsfhjdfskfjasdhdfkjahsdfkjldsfhdklsjhdsfakjlsdhfsdkjhdfskcnxmcvbmncxm"
        
//        let readMoreTextAttributes: [NSAttributedStringKey: Any] = [
//            NSAttributedStringKey.foregroundColor: self.tintColor,
//            NSAttributedStringKey.font: UIFont.boldSystemFont(ofSize: 16)
//        ]
//        let readLessTextAttributes = [
//            NSAttributedStringKey.foregroundColor: UIColor.red,
//            NSAttributedStringKey.font: UIFont.italicSystemFont(ofSize: 16)
//        ]
//        textView.attributedReadMoreText = NSAttributedString(string: "... Xem thêm", attributes: readMoreTextAttributes)
//        textView.attributedReadLessText = NSAttributedString(string: " Thu gọn", attributes: readLessTextAttributes)
//        textView.maximumNumberOfLines = 6
//        textView.shouldTrim = true

        
    }


}
