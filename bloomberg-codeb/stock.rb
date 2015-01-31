# stock.rb
require 'sinatra'

get '/' do
  res = ""
  File.open("test.txt") do |f|
    f.each_line do |line|
      res += line
    end
  end
  erb :buysell, :locals => {:res => parse(res)}
end

helpers do
  def parse(res)
    parseArr = res.split(" ")
    bidaskArr = []
    i = 0
    while i < parseArr.length do
      temp = BidAsk.new(parseArr[i], parseArr[i+1], parseArr[i+2], parseArr[i+3])
      puts(temp.getType())
      bidaskArr.push(temp)
      i += 4
    end

    return bidaskArr
  end
end


class BidAsk
  def initialize(type, stock, price, shares)
    @type = type
    @stock = stock
    @price = price
    @shares = shares
  end
  def getType()
    return @type
  end
  
  def getStock()
    return @stock
  end
  
  def getPrice()
    return @price
  end

  def getShares()
    return @shares
  end
end
