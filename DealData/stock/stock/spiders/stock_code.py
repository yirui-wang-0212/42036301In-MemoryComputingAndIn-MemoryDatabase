# -*- coding: utf-8 -*-
from scrapy.spiders import Spider
from scrapy import Request
from stock.items import StockItem
import sys

reload(sys)
sys.setdefaultencoding('utf-8')

class StockCodeSpider(Spider):
    name = 'stockCode'
    #start_urls = ['http://quote.eastmoney.com/stock_list.html']
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36',
    }

    def start_requests(self):
        url = 'http://quote.eastmoney.com/stock_list.html'
        yield Request(url, headers=self.headers)

    def parse(self, response):
        item = StockItem()
        stock_codes = response.xpath('//*[@id="quotesearch"]/ul[1]/li')

        for title in stock_codes:
            item['stock_code'] = title.xpath('.//a[@target="_blank"]/text()').extract()

            yield item

