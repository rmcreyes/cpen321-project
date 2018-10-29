var mongoose = require('mongoose');
var userSchema = mongoose.Schema;

var questionSchema = mongoose.Schema({
	question_text: {type: String, required: true},
	correct_answer: {type: String, required: true},
	incorrect_answer_1: {type: String, required: true},
	incorrect_answer_2: {type: String, required: true},
	incorrect_answer_3: {type: String, required: true},
	courseID: { type: mongoose.Schema.Types.ObjectId, ref: 'Course', required:true},
	difficulty: Number,
	creator_uID: { type: mongoose.Schema.Types.ObjectId, ref: 'User' },
	verified: Boolean,
	reported: Boolean
});

var Question = mongoose.model('Question', questionSchema);
module.exports = Question;
